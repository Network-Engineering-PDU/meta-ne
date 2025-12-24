SUMMARY = "ruamel.yaml.clib is the C based reader/scanner and emitter for ruamel.yaml"
HOMEPAGE = "https://pypi.org/project/ruamel.yaml.cli/"
AUTHOR = "Anthon van der Neut"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9dbf2e8465c3975484d69f30c72a8f"

PYPI_PACKAGE = "ruamel.yaml.clib"

inherit pypi setuptools3

SRC_URI[sha256sum] = "4ff604ce439abb20794f05613c374759ce10e3595d1867764dd1ae675b85acbd"

RDEPENDS:${PN} += ""

BBCLASSEXTEND = "native nativesdk"
