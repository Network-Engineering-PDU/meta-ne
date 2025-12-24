SUMMARY = "Generate real Swagger/OpenAPI 2.0 specifications from a Django Rest Framework API."
HOMEPAGE = "https://pypi.org/project/drf-yasg/"
AUTHOR = "Cristi V."

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=3c0faa37c940ba1fd9eac6c2fb89f053"

PYPI_PACKAGE = "drf-yasg"

inherit pypi setuptools3

SRC_URI[sha256sum] = "887c9f79e64f46aa48974234e61029b1bea6b12ea628a8fc8a3697589add1d3e"

RDEPENDS:${PN} += "python3-coreapi \
                   python3-coreschema \
                   python3-djangorestframework \
                   python3-django \
                   python3-ruamel-yaml \
                   python3-inflection \
                   python3-packaging \
                   python3-pytz \
                   python3-uritemplate"

BBCLASSEXTEND = "native nativesdk"
