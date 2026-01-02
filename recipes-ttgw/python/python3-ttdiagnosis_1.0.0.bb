# -*- mode: Conf; -*-
SUMMARY = "Network-Engineering-PDU diagnosis application"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "5773a4fb267deb86492be19b295e3a7868cb0679"
SRC_URI = "git://github.com/Network-Engineering-PDU/diagnosis.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit setuptools3 update-rc.d

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests \
"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${S}/init ${D}${sysconfdir}/init.d/ttdiagnosis
}

BBCLASSEXTEND = "native nativesdk"

INITSCRIPT_NAME = "ttdiagnosis"
INITSCRIPT_PARAMS = "defaults 75"
