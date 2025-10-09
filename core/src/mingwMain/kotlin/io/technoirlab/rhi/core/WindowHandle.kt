package io.technoirlab.rhi.core

import platform.windows.HINSTANCE
import platform.windows.HWND

actual class WindowHandle(
    val nativeHandle: HWND,
    val moduleHandle: HINSTANCE
)
