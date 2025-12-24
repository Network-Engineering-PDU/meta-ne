SUMMARY = "django-cors-headers is a Django application for handling the server headers required for Cross-Origin Resource Sharing (CORS)."
HOMEPAGE = "https://pypi.org/project/django-cors-header/"
AUTHOR = "Otto Yiu"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62e262b50dc6349305e9b03b6fdc2504"

PYPI_PACKAGE = "django-cors-headers"

inherit pypi setuptools3

SRC_URI[sha256sum] = "f9dc6b4e3f611c3199700b3e5f3398c28757dcd559c2f82932687f3d0443cfdf"

RDEPENDS:${PN} += ""

BBCLASSEXTEND = "native nativesdk"
