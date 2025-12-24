# -*- mode: Conf; -*-
SUMMARY = "Tychetools gpio module"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash"
inherit autotools pkgconfig update-rc.d

SRCBRANCH = "master"
SRCREV = "1ba067fe830e39007ac75ad81afc6eb395fe1d15"
SRC_URI = "git://bitbucket.org/tychetools/gpio_module.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

DEPENDS += "cjson libgpiod"

FILES_${PN} += " \
    ${bindir}/gpio_module \
    ${datadir}/gpio_module \
"

FILES_${PN}-dbg += " \
    ${bindir}/.debug \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${S}/scripts/init ${D}${sysconfdir}/init.d/gpio_module
}

PACKAGES = "${PN} ${PN}-dbg"
INITSCRIPT_NAME = "gpio_module"
INITSCRIPT_PARAMS = "defaults 20"
