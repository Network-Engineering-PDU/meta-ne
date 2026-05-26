SUMMARY = "Simple Python wrapper around the OpenSSL library"
HOMEPAGE = "https://pyopenssl.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://site-packages/pyOpenSSL-21.0.0.dist-info/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "openssl ${PYTHON_PN}-cryptography"

SRC_URI += " \
	https://files.pythonhosted.org/packages/1f/b1/d26236a388cf9e4b0e300e11c0f18a2f6ab3efc3b25d8d9a98abaf5a8a99/pyOpenSSL-21.0.0-py2.py3-none-any.whl\
"

SRC_URI[sha256sum] = "5e2be6f285114672fee0cdc688ab8b6b63d4019e38e891ba541c4ad3d63ed34e"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-pyopenssl"

RDEPENDS_${PN}_class-target = " \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-six \
"
