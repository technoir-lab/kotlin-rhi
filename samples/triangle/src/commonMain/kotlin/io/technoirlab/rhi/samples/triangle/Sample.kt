package io.technoirlab.rhi.samples.triangle

import io.technoirlab.rhi.core.Device
import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.rhi.core.config.RendererConfig
import io.technoirlab.rhi.samples.common.App
import io.technoirlab.rhi.samples.common.AppCallback

internal class Sample(
    private val app: App,
    private val renderer: Renderer
) : AppCallback {
    private var device: Device? = null

    override fun onLaunch() {
        val device = renderer.createDevice(app.window.handle, RendererConfig())
        this.device = device
    }

    override fun onRender() {
        val frameState = renderer.prepare()

        renderer.present(frameState)
    }

    override fun onTerminate() {
        renderer.reset()
        device?.close()
        renderer.close()
    }
}
