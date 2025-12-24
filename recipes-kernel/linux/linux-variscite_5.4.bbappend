FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://heimdall_linux_changes.patch"
SRC_URI += "file://hsd20_ips.patch"
SRC_URI += "file://defconfig"
SRC_URI += "file://imx7d-heimdall-emmc.dts"
SRC_URI += "file://imx7d-heimdall-emmc-m4.dts"
SRC_URI += "file://imx7d-heimdall-nand.dts"
SRC_URI += "file://imx7d-heimdall-nand-m4.dts"
SRC_URI += "file://imx7d-heimdall.dtsi"
SRC_URI += "file://imx7d-cm-emmc.dts"
SRC_URI += "file://imx7d-cm-emmc-m4.dts"
SRC_URI += "file://imx7d-cm-nand.dts"
SRC_URI += "file://imx7d-cm-nand-m4.dts"
SRC_URI += "file://imx7d-cm.dtsi"
SRC_URI += "file://imx7d-tt-common.dtsi"

KBUILD_DEFCONFIG_imx7-var-som = ""

do_patch_append() {

	cp ${WORKDIR}/imx7d-heimdall-emmc.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-heimdall-emmc-m4.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-heimdall-nand.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-heimdall-nand-m4.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-heimdall.dtsi ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-cm-emmc.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-cm-emmc-m4.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-cm-nand.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-cm-nand-m4.dts ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-cm.dtsi ${S}/arch/arm/boot/dts
	cp ${WORKDIR}/imx7d-tt-common.dtsi ${S}/arch/arm/boot/dts

}
