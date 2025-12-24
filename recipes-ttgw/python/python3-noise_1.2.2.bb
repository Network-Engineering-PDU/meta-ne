DESCRIPTION = "uvloop is a fast, drop-in replacement of the built-in asyncio event loop. uvloop is implemented in Cython and uses libuv under the hood."
HOMEPAGE = "https://pypi.org/project/uvloop/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=36b9a02726da8f2626d95240b9f1024a"

SRC_URI[sha256sum] = "57a2797436574391ff63a111e852e53a4164ecd81ad23639641743cd1a209b65"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

DEPENDS += "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-cython-native"
RDEPENDS:${PN} = ""
