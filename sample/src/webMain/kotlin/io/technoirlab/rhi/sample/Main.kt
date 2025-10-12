package io.technoirlab.rhi.sample

import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.rhi.webgpu.WebGpuRenderer
import kotlinx.browser.document
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLCanvasElement
import kotlin.js.ExperimentalWasmJsInterop

@OptIn(ExperimentalWasmJsInterop::class)
fun main() {
    val canvas = checkNotNull(document.getElementById("webgpu-canvas")) { "No 'webgpu-canvas' element found!" }
    val window = WindowHandle(canvas as HTMLCanvasElement)
    val sample = Sample(window, WebGpuRenderer())
    MainScope().launch {
        sample.run()
    }
}
