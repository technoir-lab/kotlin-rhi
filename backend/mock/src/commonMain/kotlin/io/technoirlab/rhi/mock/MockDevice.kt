package io.technoirlab.rhi.mock

import io.technoirlab.rhi.core.Device

class MockDevice : Device {
    override fun close() = Unit
}
