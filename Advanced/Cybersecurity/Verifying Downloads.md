**Using the download of a Kali Linux iso as an example**

## Method 1: Use SHA256

1. Generate SHA256 from a download:`$ sha256sum file_to_generate_SHA256_from`
2. Check generated SHA256 against source

## Method 2: Use PGP

Context: If you don’t trust HTTPS for authentication, you are a bit paranoid but rightfully so. There are many examples of badly managed certificate authorities that issued rogue certificates, which ended up being misused. You may also be the victim of a “friendly” man-in-the-middle attack implemented on many corporate networks, using a custom, browser-implanted trust store that presents fake certificates to encrypted websites, allowing corporate auditors to monitor encrypted traffic.

Hence, GnuPG key. We use it to sign the checksums of the images we provide. The key’s identifiers and its fingerprints are shown here:

```bash
pub rsa4096/0xED444FF07D8D0BF6 2012-03-05  [SC] [expires: 2018-02-02] Key fingerprint = 44C6 513A 8E4F B3D3 0875 F758 ED44 4FF0 7D8D 0BF6
uid [ full ] Kali Linux Repository <devel@kali.org>
sub rsa4096/0xA8373E18FC0D0DCB 2012-03-05 [E] [expires: 2018-02-02]
```

The PGP/GPG security model is very unique. Anyone can generate any key with any identity, but you would only trust that key if it has been signed by another key that you already trust. When you sign a key, you certify that you met the holder of the key and that you know that the associated identity is correct. And you define the initial set of keys that you trust, which obviously includes your own key.

This model has its own limitations so you can opt to download Kali’s public key over HTTPS (or from a keyserver) and just decide that you trust it because its fingerprint matches what was announced elsewhere.

Run either:

```bash
$ wget -q -O - https://www.kali.org/archive-key.asc | gpg --import
```

Or:

```bash
$ gpg --keyserver hkp://keys.gnupg.net --recv-key ED444FF07D8D0BF6
gpg: key 0xED444FF07D8D0BF6: public key ”Kali Linux Repository <devel@kali.org>” imported
[...]
$ gpg --fingerprint 7D8D0BF6
[...]
Key fingerprint = 44C6 513A 8E4F B3D3 0875 F758 ED44 4FF0 7D8D 0BF6
[...]
```

After you have retrieved the key, you can use it to verify the checksums of the distributed images. Let’s download the file with the checksums (SHA256SUMS) and the associated signature file (SHA256SUMS.gpg) and verify the signature:

```bash
$ wget http://cdimage.kali.org/current/SHA256SUMS
[...]
$ wget http://cdimage.kali.org/current/SHA256SUMS.gpg
[...]
$ gpg --verify SHA256SUMS.gpg SHA256SUMS
[...]
gpg: Good signature from ”Kali Linux Repository <devel@kali.org>”
```

If you get that “Good signature” message, you can trust the content of the SHA256SUMS file and use it to verify the files you downloaded. Otherwise, there is a problem. You should review whether you downloaded the files from a legitimate Kali Linux mirror.

Note that you can use the following command line to verify that the downloaded file has the same checksum that is listed in SHA256SUMS, provided that the downloaded ISO file is in the same directory:

```bash
$ grep kali-linux-2017.1-amd64.iso SHA256SUMS | sha256sum -c
kali-linux-2017.1-amd64.iso: OK
```

