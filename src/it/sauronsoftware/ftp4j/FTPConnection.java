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
package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Instances of this one represent connections with remote hosts.
 * 
 * @author Carlo Pelliccia
 */
public interface FTPConnection {

	/**
	 * This method returns the InputStream for this connection.
	 * 
	 * @return The InputStream for this connection.
	 * @throws IOException
	 *             If an I/O error occurs when creating the stream.
	 */
	public InputStream getInputStream() throws IOException;

	/**
	 * This method returns the OutputStream for this connection.
	 * 
	 * @return The OutputStream for this connection.
	 * @throws IOException
	 *             If an I/O error occurs when creating the stream.
	 */
	public OutputStream getOutputStream() throws IOException;

	/**
	 * This method closes the connection.
	 * 
	 * @throws IOException
	 *             If an I/O error occurs when closing the connection.
	 */
	public void close() throws IOException;

}
