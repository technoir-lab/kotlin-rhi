package io.technoirlab.rhi.mock

import io.technoirlab.rhi.core.Buffer
import kotlinx.io.Source

internal abstract class MockBuffer(
    override val size: UInt
) : Buffer {

    override fun updateData(source: Source, size: UInt, offset: UInt) = Unit

    override fun close() = Unit
}
