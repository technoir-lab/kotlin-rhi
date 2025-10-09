package io.technoirlab.rhi.sample

import io.technoirlab.rhi.core.Device

class Sample(deviceFactory: () -> Device) : AutoCloseable {
    private val device = deviceFactory()

    fun run() = Unit

    override fun close() {
        device.close()
    }
}
