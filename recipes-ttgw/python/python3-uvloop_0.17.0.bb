DESCRIPTION = "uvloop is a fast, drop-in replacement of the built-in asyncio event loop. uvloop is implemented in Cython and uses libuv under the hood."
HOMEPAGE = "https://pypi.org/project/uvloop/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE-MIT;md5=489c8bc34154e4b59f5c58e664f7d70f"

SRC_URI[sha256sum] = "0ddf6baf9cf11a1a22c71487f39f15b2cf78eb5bde7e5b45fbb99e8a9d91b9e1"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"


export LIBUV_CONFIGURE_HOST
LIBUV_CONFIGURE_HOST = "${HOST_SYS}"

DEPENDS += "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-cython-native"
RDEPENDS:${PN} = ""
