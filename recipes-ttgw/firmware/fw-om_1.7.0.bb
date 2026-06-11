# -*- mode: Conf; -*-
SUMMARY = "NE outlet module firmware binaries"
HOMEPAGE = "https://bitbucket.org/tychetools/fw-om/"
LICENSE = "CLOSED"

ZIP_FILE = "fw-om_1.7.0_om_boardv1.hex"
GIT_REPO = "${PN}"

SRC_URI = "https://api.bitbucket.org/2.0/repositories/tychetools/${GIT_REPO}/downloads/${ZIP_FILE};unpack=0"

S = "${WORKDIR}"

do_fetch() {
	curl -O -L -P ${DL_DIR} --user "${BITBUCKET_USER}:${BITBUCKET_PASS}" "https://api.bitbucket.org/2.0/repositories/tychetools/${GIT_REPO}/downloads/${ZIP_FILE}"
}

do_install() {
	install -d ${D}${base_prefix}/opt/${PN}
	install -m 0644 ${ZIP_FILE} ${D}${base_prefix}/opt/${PN}
}

FILES_${PN} = " \
	${base_prefix}/opt/${PN}/* \
"

PACKAGES = "${PN}"
