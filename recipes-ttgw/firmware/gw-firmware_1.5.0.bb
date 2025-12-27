# -*- mode: Conf; -*-
SUMMARY = "Tychetools gateway firmware binaries"
HOMEPAGE = "https://github.com/Network-Engineering-PDU/gw-firmware/"
LICENSE = "CLOSED"

ZIP_FILE = "gateway_heimdall_boardv2_v${PV}.zip"
GIT_REPO = "firmware"

SRC_URI = "https://github.com/Network-Engineering-PDU/${GIT_REPO}/raw/main/${ZIP_FILE};unpack=0"

S = "${WORKDIR}"

do_fetch() {
	curl -L -o ${DL_DIR}/${ZIP_FILE} "https://github.com/Network-Engineering-PDU/${GIT_REPO}/raw/main/${ZIP_FILE}"
}

do_install() {
	install -d ${D}${base_prefix}/opt/${PN}
	install -m 0644 ${ZIP_FILE} ${D}${base_prefix}/opt/${PN}
}

FILES_${PN} = " \
	${base_prefix}/opt/${PN}/* \
"

PACKAGES = "${PN}"
