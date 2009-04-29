/*
 * ftp4j - A pure Java FTP client library
 * 
 * Copyright (C) 2008-2009 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version
 * 2.1, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License version 2.1 along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnection;
import it.sauronsoftware.ftp4j.FTPConnector;

import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/**
 * The SSLConnector connects the remote host using a SSL channel.
 * 
 * @author Carlo Pelliccia
 * @since 1.2
 */
public class SSLConnector implements FTPConnector {

	/**
	 * The socket factory used by the connector.
	 */
	private SSLSocketFactory factory = null;

	/**
	 * Returns the socket factory used by the connector.
	 * 
	 * @return The socket factory.
	 * @since 1.3
	 */
	public SSLSocketFactory getSSLSocketFactory() {
		return factory;
	}

	/**
	 * Sets the socket factory used by the connector.
	 * 
	 * @param factory
	 *            The socket factory.
	 * @since 1.3
	 */
	public void setSSLSocketFactory(SSLSocketFactory factory) {
		this.factory = factory;
	}

	public FTPConnection connectForCommunicationChannel(String host, int port)
			throws IOException {
		// SSL connection.
		SocketFactory myFactory = factory != null ? factory : SSLSocketFactory
				.getDefault();
		Socket socket = myFactory.createSocket(host, port);
		return new SocketConnection(socket);
	}

	public FTPConnection connectForDataTransferChannel(String host, int port)
			throws IOException {
		// Plain connection.
		Socket socket = new Socket(host, port);
		return new SocketConnection(socket);
	}

}
