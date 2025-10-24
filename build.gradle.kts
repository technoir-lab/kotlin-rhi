plugins {
    id("io.technoirlab.conventions.root")
}

dependencies {
    dokka(project(":core"))
    dokka(project(":backend:mock"))
    dokka(project(":backend:vulkan"))
    dokka(project(":backend:webgpu"))

    nmcpAggregation(project(":core"))
    nmcpAggregation(project(":backend:mock"))
    nmcpAggregation(project(":backend:vulkan"))
    nmcpAggregation(project(":backend:webgpu"))
}
