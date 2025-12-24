DESCRIPTION = "High level compatibility layer for multiple asynchronous event loop implementations"
HOMEPAGE = "https://pypi.org/project/anyio/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-41.0.1.dist-info/LICENSE.BSD;md5=5ae30ba4123bc4f2fa49aa0b0dce887b"

WHL_FILE = "cryptography-41.0.1-cp38-cp38-linux_armv7l.whl"
GIT_NAME = "heimdall"

SRC_URI = "https://api.bitbucket.org/2.0/repositories/tychetools/${GIT_NAME}/downloads/${WHL_FILE};unpack=0"

SRC_URI[sha256sum] = "eddca883c4175f14df8aedce21054bfca3adb70ffe76a9f607aef9d7fa2ea7f0"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-cryptography"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += " openssl"
RDEPENDS:${PN} = "\
	python3-cffi\
	openssl\
"

S = "${WORKDIR}"

FILES_${PN} += "\
	${libdir}/${PYTHON_DIR}/site-packages/* \
"

do_fetch() {
	curl -O -L -P ${DL_DIR} --user "${BITBUCKET_USER}:${BITBUCKET_PASS}" "https://api.bitbucket.org/2.0/repositories/tychetools/${GIT_NAME}/downloads/${WHL_FILE}"
}

do_unpack_append(){
    bb.build.exec_func('unpack_whl', d)
}

unpack_whl() {
    rm -rf ${S}/site-packages
    mkdir ${S}/site-packages
    ${bindir}/env unzip ${S}/${WHL_FILE} -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
