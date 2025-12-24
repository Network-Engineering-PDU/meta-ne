DESCRIPTION = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "https://pypi.org/project/fastapi/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://site-packages/fastapi-0.89.0.dist-info/licenses/LICENSE;md5=95792ff3fe8e11aa49ceb247e66e4810"


SRC_URI += " \
	https://files.pythonhosted.org/packages/c2/c8/93258c8f37041196a9404b782e5da026c9c784e7fa99e685699d91d57a6e/fastapi-0.89.0-py3-none-any.whl \
"

SRC_URI[sha256sum] = "34990132751324c988db7bd15bf43a86f5c8580e58a4438e14b12d72fb0ae1d1"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-fastapi"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += ""
RDEPENDS:${PN} = "\
	python3-starlette\
	python3-pydantic\
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
    ${bindir}/env unzip ${S}/fastapi-0.89.0-py3-none-any.whl -d ${S}/site-packages
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

    cp -r ${S}/site-packages/* ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
