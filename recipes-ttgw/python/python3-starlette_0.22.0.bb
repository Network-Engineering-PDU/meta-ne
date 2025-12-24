DESCRIPTION = "The little ASGI library that shines."
HOMEPAGE = "https://pypi.org/project/starlette/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://site-packages/starlette-0.22.0.dist-info/licenses/LICENSE.md;md5=11e8c8dbfd5fa373c703de492140ff7a"

SRC_URI += " \
	https://files.pythonhosted.org/packages/1d/4e/30eda84159d5b3ad7fe663c40c49b16dd17436abe838f10a56c34bee44e8/starlette-0.22.0-py3-none-any.whl \
"

SRC_URI[sha256sum] = "b5eda991ad5f0ee5d8ce4c4540202a573bb6691ecd0c712262d0bc85cf8f2c50"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-starlette"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
	python3-idna\
	python3-sniffio\
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
    ${bindir}/env unzip ${S}/starlette-0.22.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
