DESCRIPTION = "Simple, modern and high performance file watching and code reload in python."
HOMEPAGE = "https://pypi.org/project/watchfiles/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://site-packages/watchfiles-0.19.0.dist-info/license_files/LICENSE;md5=53112d26644d450487c4d7569c3ed7e5"

SRC_URI += " \
https://files.pythonhosted.org/packages/b1/95/5fa75076399195838c618e06418dbc4996613e3e57fbecd0c1d86764afbf/watchfiles-0.19.0-cp37-abi3-manylinux_2_17_armv7l.manylinux2014_armv7l.whl \
"

SRC_URI[sha256sum] = "09ea3397aecbc81c19ed7f025e051a7387feefdb789cf768ff994c1228182fda"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-watchfiles"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = " \
	${PYTHON_PN}-anyio \
"

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
    ${bindir}/env unzip ${S}/watchfiles-0.19.0-cp37-abi3-manylinux_2_17_armv7l.manylinux2014_armv7l.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
