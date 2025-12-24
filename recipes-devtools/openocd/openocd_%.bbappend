FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
EXTRA_OECONF_append = " --enable-imx_gpio"
RDEPENDS_${PN}_append = " libgpiod"

SRC_URI += "file://heimdall.cfg"

do_install_append () {
	install -m 644 ${WORKDIR}/heimdall.cfg ${D}${datadir}/openocd/scripts/heimdall.cfg
}
