SUMMARY = "A minimal JSON Web Token authentication plugin for Django REST Framework"
HOMEPAGE = "https://pypi.org/project/djangorestframework-simplejwt/"
AUTHOR = "David Sanders"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f24875dafb0c8c58d3ab5f169d63b79c"

PYPI_PACKAGE = "djangorestframework_simplejwt"

inherit pypi setuptools3

SRC_URI[sha256sum] = "d27d4bcac2c6394f678dea8b4d0d511c6e18a7f2eb8aaeeb8a7de601aeb77c42"

DEPENDS += " python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-django \
                   python3-djangorestframework \
                   python3-pyjwt"

BBCLASSEXTEND = "native nativesdk"
