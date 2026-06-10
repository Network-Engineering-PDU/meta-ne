SUMMARY = "A faster Python DBus library"
HOMEPAGE = "https://github.com/bluez/dbus-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94e750c96e56788499b56c81de91431c"

PYPI_PACKAGE = "dbus-fast"

SRC_URI[sha256sum] = "9042a1b565ecac4f8e04df79376de1d1d31e4c82eddb6e71e8b8d82d0c94dd3d"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
