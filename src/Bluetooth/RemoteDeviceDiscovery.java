/**
 * BlueCove - Java library for Bluetooth Copyright (C) 2006-2009 Vlad
 * Skarzhevskyy
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * @author vlads
 * @version $Id$
 */
//https://code.google.com/p/bluecove/source/browse/#svn%2Ftrunk%2Fbluecove%2Fsrc%2Ftest%2Fjava%2Fcom%2Fintel%2Fbluetooth%2Ftest%253Fstate%253Dclosed
package Bluetooth;

import java.io.IOException;
import java.util.ArrayList;
import javax.bluetooth.*;

/**
 *
 * @Modifyed by Christian Bodelsson <bodelsson@gmail.com>
 */
public class RemoteDeviceDiscovery {

    public static final ArrayList<RemoteDevice> devicesDiscovered = new ArrayList();

    public static void main(String[] args) throws IOException, InterruptedException {

        final Object inquiryCompletedEvent = new Object();

        devicesDiscovered.clear();

        DiscoveryListener listener;
        listener = new DiscoveryListener() {
            
            @Override
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                System.out.println("Device " + btDevice.getBluetoothAddress() + " found");
                devicesDiscovered.add(btDevice);
                try {
                    System.out.println("     name " + btDevice.getFriendlyName(false));
                } catch (IOException cantGetDeviceName) {
                }
            }

            @Override
            public void inquiryCompleted(int discType) {
                System.out.println("Device Inquiry completed!");
                synchronized (inquiryCompletedEvent) {
                    inquiryCompletedEvent.notifyAll();
                }
            }

            @Override
            public void serviceSearchCompleted(int transID, int respCode) {
            }

            @Override
            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        };

        synchronized (inquiryCompletedEvent) {
            boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (started) {
                System.out.println("wait for device inquiry to complete...");
                inquiryCompletedEvent.wait();
                System.out.println(devicesDiscovered.size() + " device(s) found");
            }
        }
    }

}
