/*
 * Copyright 2015 Odnoklassniki Ltd, Mail.Ru Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package one.nio.net;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.channels.ServerSocketChannel;

final class JavaServerSocket extends Socket {
    ServerSocketChannel ch;

    JavaServerSocket() throws IOException {
        this.ch = ServerSocketChannel.open();
    }

    @Override
    public final boolean isOpen() {
        return ch.isOpen();
    }

    @Override
    public final void close() {
        try {
            ch.close();
        } catch (IOException e) {
            // Ignore
        }
    }

    @Override
    public final JavaSocket accept() throws IOException {
        return new JavaSocket(ch.accept());
    }

    @Override
    public final void connect(InetAddress address, int port) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void bind(InetAddress address, int port, int backlog) throws IOException {
        ch.socket().bind(new InetSocketAddress(address, port), backlog);
    }

    @Override
    public final int writeRaw(long buf, int count, int flags) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int write(byte[] data, int offset, int count, int flags) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void writeFully(byte[] data, int offset, int count) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int readRaw(long buf, int count, int flags) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int read(byte[] data, int offset, int count) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void readFully(byte[] data, int offset, int count) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final long sendFile(RandomAccessFile file, long offset, long count) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void setBlocking(boolean blocking) {
        try {
            ch.configureBlocking(blocking);
        } catch (IOException e) {
            // Ignore
        }
    }

    @Override
    public final void setTimeout(int timeout) {
        try {
            ch.socket().setSoTimeout(timeout);
        } catch (SocketException e) {
            // Ignore
        }
    }

    @Override
    public final void setKeepAlive(boolean keepAlive) {
        // Ignore
    }

    @Override
    public final void setNoDelay(boolean noDelay) {
        // Ignore
    }

    @Override
    public final void setDeferAccept(boolean deferAccept) {
        // Ignore
    }

    @Override
    public final void setReuseAddr(boolean reuseAddr) {
        try {
            ch.socket().setReuseAddress(reuseAddr);
        } catch (SocketException e) {
            // Ignore
        }
    }

    @Override
    public final void setRecvBuffer(int recvBuf) {
        try {
            ch.socket().setReceiveBufferSize(recvBuf);
        } catch (SocketException e) {
            // Ignore
        }
    }

    @Override
    public final void setSendBuffer(int sendBuf) {
        // Ignore
    }

    @Override
    public byte[] getOption(int level, int option) {
        return null;
    }

    @Override
    public boolean setOption(int level, int option, byte[] value) {
        return false;
    }

    @Override
    public final InetSocketAddress getLocalAddress() {
        return (InetSocketAddress) ch.socket().getLocalSocketAddress();
    }

    @Override
    public final InetSocketAddress getRemoteAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket ssl(SslContext context) {
        return this;
    }

    @Override
    public SslContext getSslContext() {
        return null;
    }
}
