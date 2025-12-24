DESCRIPTION = "A streaming multipart parser for Python"
HOMEPAGE = "https://pypi.org/project/python-multipart/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=6c0c06fcb50bf07318f487fcf8c5da80"

SRC_URI[sha256sum] = "f7bb5f611fc600d15fa47b3974c8aa16e93724513b49b5f95c81e6624c83fa43"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

DEPENDS += ""
RDEPENDS:${PN} = ""
