using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.Seguridad
{
    class TripleDes
    {
        private string encrypt(string text) {
            
            byte[] bytesToEncode = Encoding.UTF8.GetBytes(text);
            string encodedText = Convert.ToBase64String(bytesToEncode);

            return encodedText;
        }
        private string decrypt(string text) {
            byte[] decodedBytes = Convert.FromBase64String(text);
            string decodedText = Encoding.UTF8.GetString(decodedBytes);
            return decodedText;
        }
    }
}
