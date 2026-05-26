SUMMARY = "Simple Python wrapper around the OpenSSL library"
HOMEPAGE = "https://pyopenssl.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://site-packages/pyOpenSSL-24.1.0.dist-info/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "openssl ${PYTHON_PN}-cryptography"

SRC_URI += " \
	https://files.pythonhosted.org/packages/f0/92/8a0e1da52e0dccff0b5c8c53fc47ae17da9b53a69cdc88fc0a6d006cda34/pyOpenSSL-24.1.0-py3-none-any.whl\
"

SRC_URI[sha256sum] = "f0ea8ad668b37990a9b49a0cef6c3e39aa126150c1d6d1e7139c0b23799c4410"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

PROVIDES += "python3-pyopenssl"

RDEPENDS_${PN}_class-target = " \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-six \
"
