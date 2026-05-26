DESCRIPTION = "Python wrapper module around the OpenSSL library"
HOMEPAGE = "https://github.com/pyca/pyopenssl"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd36"

PYPI_PACKAGE = "pyOpenSSL"

inherit pypi python3-dir python3native

SRC_URI[sha256sum] = "cd4a529681c30d54f6a1f1dd96ae1ba17acd9e1c7b09bfb8e8c5c7a4f8e6c8c2"

RDEPENDS:${PN} = "\
    python3-cryptography \
    python3-cffi \
"

DEPENDS = "python3-setuptools-scm-native"
