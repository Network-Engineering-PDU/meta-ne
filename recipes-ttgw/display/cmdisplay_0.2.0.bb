# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU NE display for PDUs"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/ttne-display/"
LICENSE = "CLOSED"

SRCBRANCH = "main"
SRCREV = "d94c9177f7354a9eef7bfd6af898e33ab98e913d"
SRC_URI = "git://github.com/Network-Engineering-PDU/ttne-display.git;protocol=https;branch=${SRCBRANCH}"

SRC_URI += "\
    file://findcjson.patch\
	file://init \
"

S = "${WORKDIR}/git"

inherit cmake pkgconfig update-rc.d

EXTRA_OECMAKE = "\
    -DASSET_PATH="\"A:/usr/share/cmdisplay/assets/\""\
"
#-DCJSON_INCLUDE_DIR="/include"
#-DCJSON_LIBRARIES="/lib"
#-DCMAKE_DISABLE_FIND_PACKAGE_cJSON="TRUE"

DEPENDS += "cjson curl"

RDEPENDS_${PN} = "\
"


do_configure_prepend() {
    cd ${S}
    git submodule update --init --recursive

}

FILES_${PN} += " \
    ${bindir}/cmdisplay \
    ${datadir}/cmdisplay/* \
"

do_install_append() {
    install -d ${D}${datadir}/cmdisplay
    cp -r ${S}/assets ${D}${datadir}/cmdisplay/

    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/cmdisplay
}

INITSCRIPT_NAME = "cmdisplay"
INITSCRIPT_PARAMS = "defaults 40"


