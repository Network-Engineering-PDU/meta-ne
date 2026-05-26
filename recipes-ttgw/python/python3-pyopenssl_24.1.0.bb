SUMMARY = "Simple Python wrapper around the OpenSSL library"
HOMEPAGE = "https://pyopenssl.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://site-packages/pyOpenSSL-24.1.0.dist-info/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "openssl ${PYTHON_PN}-cryptography"

SRC_URI += " \
	https://files.pythonhosted.org/packages/6f/b6/3a51b0924339a3a25274b245b76e5e10831e310ba44077c1427c90c4f5a7/pyOpenSSL-24.1.0-py3-none-any.whl\
"

SRC_URI[sha256sum] = "17ed5be5936449c5418d1cd269a1a9e9081bc54c17aed272b45856a3d3dc86ad"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-pyopenssl"

RDEPENDS_${PN}_class-target = " \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
"
do_unpack[depends] += "unzip-native:do_populate_sysroot"

S = "${WORKDIR}"

FILES_${PN} += "\
	${libdir}/${PYTHON_DIR}/site-packages/* \
"

do_unpack_append(){
    bb.build.exec_func('unpack_whl', d)
}

unpack_whl() {
    rm -rf ${S}/site-packages
    mkdir ${S}/site-packages
    ${bindir}/env unzip ${S}/pyOpenSSL-24.1.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
