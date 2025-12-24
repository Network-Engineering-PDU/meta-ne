SUMMARY = "Backport of the standard library zoneinfo module"
HOMEPAGE = "https://pypi.org/project/backports.zoneinfo/"
AUTHOR = "Python Software Foundation"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fca9fd5c15a28eb874ba38577a585d48"

PYPI_PACKAGE = "backports.zoneinfo"

inherit pypi setuptools3

SRC_URI[sha256sum] = "fadbfe37f74051d024037f223b8e001611eac868b5c5b06144ef4d8b799862f2"

RDEPENDS:${PN} += ""

BBCLASSEXTEND = "native nativesdk"
