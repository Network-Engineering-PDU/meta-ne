DESCRIPTION = "Sniff out which async library your code is running under"
HOMEPAGE = "https://pypi.org/project/sniffio/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://site-packages/sniffio-1.3.0.dist-info/LICENSE.MIT;md5=e62ba5042d5983462ad229f5aec1576c"

SRC_URI += " \
	https://files.pythonhosted.org/packages/c3/a0/5dba8ed157b0136607c7f2151db695885606968d1fae123dc3391e0cfdbf/sniffio-1.3.0-py3-none-any.whl \
"

SRC_URI[sha256sum] = "eecefdce1e5bbfb7ad2eeaabf7c1eeb404d7757c379bd1f7e5cce9d8bf425384"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

BBCLASSEXTEND = "native nativesdk"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = ""

PROVIDES += "python3-sniffio"


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
    ${bindir}/env unzip ${S}/sniffio-1.3.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
