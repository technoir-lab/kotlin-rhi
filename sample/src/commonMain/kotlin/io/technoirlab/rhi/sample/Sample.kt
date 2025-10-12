package io.technoirlab.rhi.sample

import io.technoirlab.rhi.core.Device
import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.rhi.core.config.RendererConfig

internal class Sample(
    private val window: WindowHandle,
    private val renderer: Renderer
) : AutoCloseable {

    private val config = RendererConfig()
    private lateinit var device: Device

    suspend fun run() {
        device = renderer.createDevice(window, config)
        println("Device created")
    }

    override fun close() {
        device.close()
        renderer.close()
    }
}
