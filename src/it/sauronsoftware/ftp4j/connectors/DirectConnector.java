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

/**
 * The DirectConnector connects the remote host with a straight socket
 * connection, using no proxy.
 * 
 * @author Carlo Pelliccia
 */
public class DirectConnector implements FTPConnector {

	private FTPConnection connect(String host, int port) throws IOException {
		Socket socket = new Socket(host, port);
		return new SocketConnection(socket);
	}

	public FTPConnection connectForCommunicationChannel(String host, int port)
			throws IOException {
		return connect(host, port);
	}

	public FTPConnection connectForDataTransferChannel(String host, int port)
			throws IOException {
		return connect(host, port);
	}

}
