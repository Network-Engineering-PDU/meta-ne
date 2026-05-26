SUMMARY = "Simple Python wrapper around the OpenSSL library"
HOMEPAGE = "https://pyopenssl.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://site-packages/pyOpenSSL-24.1.0.dist-info/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "openssl ${PYTHON_PN}-cryptography"

SRC_URI += " \
	https://files.pythonhosted.org/packages/54/a7/2104f674a5a6845b04c8ff01659becc6b8978ca410b82b94287e0b1e018b/pyOpenSSL-24.1.0-py3-none-any.whl\
"

SRC_URI[sha256sum] = "17ed5be5936449c5418d1cd269a1a9e9081bc54c17aed272b45856a3d3dc86ad"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-pyopenssl"

RDEPENDS_${PN}_class-target = " \
    ${PYTHON_PN}-cryptography \
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
    ${bindir}/env unzip ${S}/pyOpenSSL-23.1.1-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
