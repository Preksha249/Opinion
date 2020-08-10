/*
  Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.mysqla.io;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for {@link DebugBufferingPacketSender}.
 */
public class DebugBufferingPacketSenderTest extends PacketSenderTestBase {
    @Test
    public void packetPushedToDebugBufferTest() throws IOException {
        List<StringBuilder> debugBuffer = new ArrayList<StringBuilder>();
        DebugBufferingPacketSender sender = new DebugBufferingPacketSender(getNoopPacketSender(), debugBuffer);
        byte packet[] = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        sender.send(packet, 8, (byte) 0);

        // check that packet was appended to the debug buffer
        String debugText = debugBuffer.get(0).toString();
        System.out.println("Debug text is: " + debugText);
        // simple best-effort to make sure we have something reasonable
        Pattern p = Pattern.compile("Packet payload:.*00 01 02 03 04 05 06 07", Pattern.DOTALL);
        assertTrue(p.matcher(debugText).find());
    }
}
