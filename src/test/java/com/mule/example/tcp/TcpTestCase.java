/*
 * Generated by the Mule project wizard. http://mule.mulesoft.org
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.mule.example.tcp;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.NullPayload;

import static org.junit.Assert.*;

public class TcpTestCase extends FunctionalTestCase
{
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    @Test
    public void tcpTest() throws Exception
    {
        MuleClient client = muleContext.getClient();
        MuleMessage result = client.send("tcpendpoint", new DataObject(1234), null);

        assertNotNull(result);
        assertNull(result.getExceptionPayload());
        assertFalse(result.getPayload() instanceof NullPayload);

        // Assert that the expected payload has been received.
        assertTrue(result.getPayload() instanceof DataObject);

        DataObject dataObject = (DataObject) result.getPayload();

        // Assert id returned as expected (note: Echo increments id by 1)
        assertEquals(1235, (int)dataObject.getId());
    }
}
