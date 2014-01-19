using desguaceNET.libSOR.BD;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET
{
    class DesguaceNet
    {
        InterfazBD bd;
        
    public bool activarDesguacesBD(string idRecibido) {
        try {
            bd = new InterfazBD("sor_desguace");
            boolean r = bd.activarDesguaceMainDesguace(idRecibido);
            bd.close();
            return r;
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    }
}
