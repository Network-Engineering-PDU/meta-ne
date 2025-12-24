DESCRIPTION = "Composable command line interface toolkit"
HOMEPAGE = "https://pypi.org/project/click/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1fa98232fd645608937a0fdc82e999b8"

SRC_URI[sha256sum] = "7682dc8afb30297001674575ea00d1814d808d6a36af415a82bd481d37ba7b8e"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

DEPENDS += ""
RDEPENDS:${PN} = ""
