/**
 * Validates an IPv4 address.
 * @param {string} ipv4 - The IPv4 address to validate.
 * @returns {boolean} - True if the IPv4 address is valid, false otherwise.
 */
function isValidIPv4(ipv4) {
    const ipv4Segments = ipv4.split(".");
    if (ipv4Segments.length !== 4) return false;
    for (const ipv4Segment of ipv4Segments) {
        if (!isValidIPv4Segment(ipv4Segment)) return false;
    }
    return true;
}
/**
 * Validates an octet of an IPv4 address.
 * @param {string} ipv4Segment - The octet to validate.
 * @returns {boolean} - True if the octet is valid, false otherwise.
 */
function isValidIPv4Segment(ipv4Segment) {
    const ipv4SegmentNumber = +ipv4Segment;
    if (
        ipv4Segment.length <= 0 ||
        ipv4Segment.length > 3 ||
        Number.isNaN(ipv4SegmentNumber) ||
        (ipv4Segment.startsWith(0) && ipv4Segment !== "0") ||
        ipv4SegmentNumber < 0 ||
        ipv4SegmentNumber > 255
    ) {
        return false;
    }
    return true;
}
