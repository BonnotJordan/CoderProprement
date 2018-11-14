package com.amiltone.ci.model.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by amiltonedev_lt050 on 04/11/2017.
 */
public class BLEDeviceMockFailureImplTest {

    private BLEDevice bleDevice;

    @Before
    public void setUp() {
        bleDevice = new BLEDeviceMockFailureImpl();
    }

    @Test
    public void getLastValue() {
        assertThat(bleDevice.getLastValue()).isNullOrEmpty();
    }

    @Test
    public void getLastValues() {
        assertThat(bleDevice.getLastValues()).isNullOrEmpty();
    }

    @Test
    public void pairConnectDevice() {
        bleDevice.pairConnectDevice();
        assertThat(bleDevice.getStatus()).isEqualTo(BLEDevice.OFFLINE);
    }
}