package io.technoirlab.rhi.samples.triangle

import io.technoirlab.rhi.samples.common.App
import io.technoirlab.rhi.samples.common.createRenderer

fun main() {
    val app = App()
    val sample = Sample(app, createRenderer())
    app.run(sample)
}
