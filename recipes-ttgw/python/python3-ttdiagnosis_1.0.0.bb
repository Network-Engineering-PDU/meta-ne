# -*- mode: Conf; -*-
SUMMARY = "Tychetools diagnosis application"
LICENSE = "CLOSED"

SRCBRANCH = "devel"
SRCREV = "28e5e8b649c3888737a687d1e1daf1ace2276f07"
SRC_URI = "git://bitbucket.org/tychetools/diagnosis.git;protocol=ssh;branch=${SRCBRANCH}"

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
