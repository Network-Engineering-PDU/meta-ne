SUMMARY = "Bluetooth Low Energy platform Agnostic Klient"
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94e750c96e56788499b56c81de91431c"

PYPI_PACKAGE = "bleak"

SRC_URI[sha256sum] = "ec4a1a2772fb315b992cbaa1153070c7e26968a52b0e2727035f443a1af5c18f"

inherit pypi setuptools3

RDEPENDS_${PN} = "\
    python3-async-timeout \
    python3-dbus-fast \
    python3-typing-extensions \
"

BBCLASSEXTEND = "native nativesdk"
