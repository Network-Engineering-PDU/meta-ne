SUMMARY = "Simple Python wrapper around the OpenSSL library"
HOMEPAGE = "https://pyopenssl.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://site-packages/pyOpenSSL-23.1.1.dist-info/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "openssl ${PYTHON_PN}-cryptography"

SRC_URI += " \
	https://files.pythonhosted.org/packages/b7/6d/d7377332703ffd8821878794aca4fb54637da654bf3e467ffb32109c2147/pyOpenSSL-23.1.1-py3-none-any.whl\
"

SRC_URI[sha256sum] = "9e0c526404a210df9d2b18cd33364beadb0dc858a739b885677bc65e105d4a4c"

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
    ${bindir}/env unzip ${S}/pyOpenSSL-23.1.1-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
