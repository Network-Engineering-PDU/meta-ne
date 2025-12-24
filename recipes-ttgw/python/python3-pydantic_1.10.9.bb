DESCRIPTION = "Data validation and settings management using python type hints"
HOMEPAGE = "https://pypi.org/project/pydantic/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

SRC_URI[sha256sum] = "95c70da2cd3b6ddf3b9645ecaa8d98f3d80c606624b6d245558d202cd23ea3be"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

DEPENDS += ""
RDEPENDS:${PN} = ""
