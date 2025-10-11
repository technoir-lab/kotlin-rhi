package io.technoirlab.rhi.core.config

data class RendererConfig(
    val deviceName: String? = null,
    val tripleBuffering: Boolean = false,
    val syncMode: SyncMode = SyncMode.VSync,
    val hdr: Boolean = false,
    val depthStencilBuffer: Boolean = true,
)
