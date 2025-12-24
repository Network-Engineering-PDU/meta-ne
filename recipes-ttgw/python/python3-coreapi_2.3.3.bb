SUMMARY = "Python client library for Core API."
HOMEPAGE = "https://pypi.org/project/coreapi/"
AUTHOR = "Tom Christie"

LICENSE = "CLOSED"

PYPI_PACKAGE = "coreapi"

inherit pypi setuptools3

SRC_URI[sha256sum] = "46145fcc1f7017c076a2ef684969b641d18a2991051fddec9458ad3f78ffc1cb"

RDEPENDS:${PN} += "python3-coreschema \
                   python3-requests \
                   python3-itypes \
                   python3-uritemplate"

BBCLASSEXTEND = "native nativesdk"

