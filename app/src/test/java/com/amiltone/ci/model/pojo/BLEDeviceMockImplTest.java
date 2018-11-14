package com.amiltone.ci.model.pojo;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by amiltonedev_lt050 on 04/11/2017.
 */
public class BLEDeviceMockImplTest {
    private BLEDevice bleDevice;

    @Before
    public void setUp() {
        bleDevice = new BLEDeviceMockImpl();
    }

    @Test
    public void getLastValue() {
        String lastValue = bleDevice.getLastValue();
        assertThat(lastValue).isNotNull();
        assertThat(lastValue.length()).isGreaterThan(0);
    }

    @Test
    public void getLastValues() {
        List<String> lastValues = bleDevice.getLastValues();
        assertThat(lastValues).isNotNull();
        assertThat(lastValues.size()).isEqualTo(15);
    }

    @Test
    public void pairConnectDevice() {
        bleDevice.pairConnectDevice();
        assertThat(bleDevice.getStatus()).isEqualTo(BLEDevice.CONNECTED);
    }

}